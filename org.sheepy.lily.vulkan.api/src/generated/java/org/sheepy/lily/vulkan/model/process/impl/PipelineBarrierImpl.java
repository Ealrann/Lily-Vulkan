/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.util.LTreeIterator;

import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.root.LObject;

import org.sheepy.lily.core.model.root.RootPackage.Literals;

import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.barrier.Barrier;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getBarriers <em>Barriers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getSrcStage <em>Src Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getDstStage <em>Dst Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getSrcQueue <em>Src Queue</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getDstQueue <em>Dst Queue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PipelineBarrierImpl extends MinimalEObjectImpl.Container implements PipelineBarrier
{
	/**
	 * The cached value of the '{@link #getContentObjects() <em>Content Objects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<LObject> contentObjects;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBarriers() <em>Barriers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBarriers()
	 * @generated
	 * @ordered
	 */
	protected EList<Barrier> barriers;

	/**
	 * The default value of the '{@link #getSrcStage() <em>Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage SRC_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getSrcStage() <em>Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage srcStage = SRC_STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstStage() <em>Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage DST_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getDstStage() <em>Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage dstStage = DST_STAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSrcQueue() <em>Src Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcQueue()
	 * @generated
	 * @ordered
	 */
	protected AbstractProcess srcQueue;

	/**
	 * The cached value of the '{@link #getDstQueue() <em>Dst Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstQueue()
	 * @generated
	 * @ordered
	 */
	protected AbstractProcess dstQueue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipelineBarrierImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ProcessPackage.Literals.PIPELINE_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LObject> getContentObjects()
	{
		return contentObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContentObjects(EList<LObject> newContentObjects)
	{
		EList<LObject> oldContentObjects = contentObjects;
		contentObjects = newContentObjects;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE_BARRIER__CONTENT_OBJECTS, oldContentObjects,
				contentObjects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE_BARRIER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE_BARRIER__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Barrier> getBarriers()
	{
		if (barriers == null)
		{
			barriers = new EObjectContainmentEList<Barrier>(Barrier.class, this,
					ProcessPackage.PIPELINE_BARRIER__BARRIERS);
		}
		return barriers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getSrcStage()
	{
		return srcStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcStage(EPipelineStage newSrcStage)
	{
		EPipelineStage oldSrcStage = srcStage;
		srcStage = newSrcStage == null ? SRC_STAGE_EDEFAULT : newSrcStage;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE_BARRIER__SRC_STAGE, oldSrcStage, srcStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getDstStage()
	{
		return dstStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstStage(EPipelineStage newDstStage)
	{
		EPipelineStage oldDstStage = dstStage;
		dstStage = newDstStage == null ? DST_STAGE_EDEFAULT : newDstStage;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE_BARRIER__DST_STAGE, oldDstStage, dstStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractProcess getSrcQueue()
	{
		if (srcQueue != null && srcQueue.eIsProxy())
		{
			InternalEObject oldSrcQueue = (InternalEObject) srcQueue;
			srcQueue = (AbstractProcess) eResolveProxy(oldSrcQueue);
			if (srcQueue != oldSrcQueue)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE, oldSrcQueue, srcQueue));
			}
		}
		return srcQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcess basicGetSrcQueue()
	{
		return srcQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcQueue(AbstractProcess newSrcQueue)
	{
		AbstractProcess oldSrcQueue = srcQueue;
		srcQueue = newSrcQueue;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE, oldSrcQueue, srcQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractProcess getDstQueue()
	{
		if (dstQueue != null && dstQueue.eIsProxy())
		{
			InternalEObject oldDstQueue = (InternalEObject) dstQueue;
			dstQueue = (AbstractProcess) eResolveProxy(oldDstQueue);
			if (dstQueue != oldDstQueue)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ProcessPackage.PIPELINE_BARRIER__DST_QUEUE, oldDstQueue, dstQueue));
			}
		}
		return dstQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcess basicGetDstQueue()
	{
		return dstQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstQueue(AbstractProcess newDstQueue)
	{
		AbstractProcess oldDstQueue = dstQueue;
		dstQueue = newDstQueue;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE_BARRIER__DST_QUEUE, oldDstQueue, dstQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends LObject> EList<T> createContainmentEList(final EClass targetEClass)
	{
		EList<T> res = null;
		final List<EStructuralFeature> unitRefs = new ArrayList<EStructuralFeature>();
		EList<EReference> _eAllContainments = this.eClass().getEAllContainments();
		for (final EReference ref : _eAllContainments)
		{
			EClassifier _eType = ref.getEType();
			boolean _isSuperTypeOf = targetEClass.isSuperTypeOf(((EClass) _eType));
			if (_isSuperTypeOf)
			{
				unitRefs.add(ref);
			}
		}
		boolean _isEmpty = unitRefs.isEmpty();
		if (_isEmpty)
		{
			res = ECollections.<T> emptyEList();
		}
		else
		{
			EContentsEList<T> _eContentsEList = new EContentsEList<T>(this, unitRefs);
			res = _eContentsEList;
		}
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LObject> lContents()
	{
		EList<LObject> _xblockexpression = null;
		{
			EList<LObject> _contentObjects = this.getContentObjects();
			boolean _tripleEquals = (_contentObjects == null);
			if (_tripleEquals)
			{
				this.setContentObjects(this.<LObject> createContainmentEList(Literals.LOBJECT));
			}
			_xblockexpression = this.getContentObjects();
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LObject lParent()
	{
		LObject _xifexpression = null;
		EObject _eContainer = this.eContainer();
		if ((_eContainer instanceof LObject))
		{
			EObject _eContainer_1 = this.eContainer();
			_xifexpression = ((LObject) _eContainer_1);
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LTreeIterator lAllContents()
	{
		return new LTreeIterator(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IInferenceObject lInferenceObject()
	{
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
			return ((InternalEList<?>) getBarriers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
		case ProcessPackage.PIPELINE_BARRIER__CONTENT_OBJECTS:
			return getContentObjects();
		case ProcessPackage.PIPELINE_BARRIER__NAME:
			return getName();
		case ProcessPackage.PIPELINE_BARRIER__ENABLED:
			return isEnabled();
		case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
			return getBarriers();
		case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
			return getSrcStage();
		case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
			return getDstStage();
		case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
			if (resolve) return getSrcQueue();
			return basicGetSrcQueue();
		case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
			if (resolve) return getDstQueue();
			return basicGetDstQueue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case ProcessPackage.PIPELINE_BARRIER__CONTENT_OBJECTS:
			setContentObjects((EList<LObject>) newValue);
			return;
		case ProcessPackage.PIPELINE_BARRIER__NAME:
			setName((String) newValue);
			return;
		case ProcessPackage.PIPELINE_BARRIER__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
			getBarriers().clear();
			getBarriers().addAll((Collection<? extends Barrier>) newValue);
			return;
		case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
			setSrcStage((EPipelineStage) newValue);
			return;
		case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
			setDstStage((EPipelineStage) newValue);
			return;
		case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
			setSrcQueue((AbstractProcess) newValue);
			return;
		case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
			setDstQueue((AbstractProcess) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
		case ProcessPackage.PIPELINE_BARRIER__CONTENT_OBJECTS:
			setContentObjects((EList<LObject>) null);
			return;
		case ProcessPackage.PIPELINE_BARRIER__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ProcessPackage.PIPELINE_BARRIER__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
			getBarriers().clear();
			return;
		case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
			setSrcStage(SRC_STAGE_EDEFAULT);
			return;
		case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
			setDstStage(DST_STAGE_EDEFAULT);
			return;
		case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
			setSrcQueue((AbstractProcess) null);
			return;
		case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
			setDstQueue((AbstractProcess) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
		case ProcessPackage.PIPELINE_BARRIER__CONTENT_OBJECTS:
			return contentObjects != null;
		case ProcessPackage.PIPELINE_BARRIER__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ProcessPackage.PIPELINE_BARRIER__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
			return barriers != null && !barriers.isEmpty();
		case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
			return srcStage != SRC_STAGE_EDEFAULT;
		case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
			return dstStage != DST_STAGE_EDEFAULT;
		case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
			return srcQueue != null;
		case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
			return dstQueue != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == LNamedElement.class)
		{
			switch (derivedFeatureID)
			{
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				return TypesPackage.LNAMED_ELEMENT__NAME;
			default:
				return -1;
			}
		}
		if (baseClass == IPipelineTask.class)
		{
			switch (derivedFeatureID)
			{
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				return ProcessPackage.IPIPELINE_TASK__ENABLED;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == LNamedElement.class)
		{
			switch (baseFeatureID)
			{
			case TypesPackage.LNAMED_ELEMENT__NAME:
				return ProcessPackage.PIPELINE_BARRIER__NAME;
			default:
				return -1;
			}
		}
		if (baseClass == IPipelineTask.class)
		{
			switch (baseFeatureID)
			{
			case ProcessPackage.IPIPELINE_TASK__ENABLED:
				return ProcessPackage.PIPELINE_BARRIER__ENABLED;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (contentObjects: ");
		result.append(contentObjects);
		result.append(", name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", srcStage: ");
		result.append(srcStage);
		result.append(", dstStage: ");
		result.append(dstStage);
		result.append(')');
		return result.toString();
	}

} //PipelineBarrierImpl
