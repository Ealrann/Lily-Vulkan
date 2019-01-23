/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
import org.sheepy.lily.core.api.util.LTreeIterator;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.core.model.root.RootPackage.Literals;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.Barrier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getBarrier <em>Barrier</em>}</li>
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
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final ECommandStage STAGE_EDEFAULT = ECommandStage.RENDER;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected ECommandStage stage = STAGE_EDEFAULT;

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
	 * The cached value of the '{@link #getBarrier() <em>Barrier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBarrier()
	 * @generated
	 * @ordered
	 */
	protected Barrier barrier;

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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__CONTENT_OBJECTS, oldContentObjects, contentObjects));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECommandStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(ECommandStage newStage)
	{
		ECommandStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__STAGE, oldStage, stage));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Barrier getBarrier()
	{
		return barrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBarrier(Barrier newBarrier, NotificationChain msgs)
	{
		Barrier oldBarrier = barrier;
		barrier = newBarrier;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__BARRIER, oldBarrier, newBarrier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarrier(Barrier newBarrier)
	{
		if (newBarrier != barrier)
		{
			NotificationChain msgs = null;
			if (barrier != null)
				msgs = ((InternalEObject)barrier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.PIPELINE_BARRIER__BARRIER, null, msgs);
			if (newBarrier != null)
				msgs = ((InternalEObject)newBarrier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.PIPELINE_BARRIER__BARRIER, null, msgs);
			msgs = basicSetBarrier(newBarrier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__BARRIER, newBarrier, newBarrier));
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
			InternalEObject oldSrcQueue = (InternalEObject)srcQueue;
			srcQueue = (AbstractProcess)eResolveProxy(oldSrcQueue);
			if (srcQueue != oldSrcQueue)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE, oldSrcQueue, srcQueue));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE, oldSrcQueue, srcQueue));
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
			InternalEObject oldDstQueue = (InternalEObject)dstQueue;
			dstQueue = (AbstractProcess)eResolveProxy(oldDstQueue);
			if (dstQueue != oldDstQueue)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.PIPELINE_BARRIER__DST_QUEUE, oldDstQueue, dstQueue));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__DST_QUEUE, oldDstQueue, dstQueue));
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
			res = ECollections.<T>emptyEList();
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
				this.setContentObjects(this.<LObject>createContainmentEList(Literals.LOBJECT));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ProcessPackage.PIPELINE_BARRIER__BARRIER:
				return basicSetBarrier(null, msgs);
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
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				return isEnabled();
			case ProcessPackage.PIPELINE_BARRIER__STAGE:
				return getStage();
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				return getName();
			case ProcessPackage.PIPELINE_BARRIER__BARRIER:
				return getBarrier();
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
				setContentObjects((EList<LObject>)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__STAGE:
				setStage((ECommandStage)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__BARRIER:
				setBarrier((Barrier)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
				setSrcQueue((AbstractProcess)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
				setDstQueue((AbstractProcess)newValue);
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
				setContentObjects((EList<LObject>)null);
				return;
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__STAGE:
				setStage(STAGE_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__BARRIER:
				setBarrier((Barrier)null);
				return;
			case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
				setSrcQueue((AbstractProcess)null);
				return;
			case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
				setDstQueue((AbstractProcess)null);
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
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.PIPELINE_BARRIER__STAGE:
				return stage != STAGE_EDEFAULT;
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.PIPELINE_BARRIER__BARRIER:
				return barrier != null;
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
				case ProcessPackage.PIPELINE_BARRIER__NAME: return TypesPackage.LNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == IPipelineUnit.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
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
				case TypesPackage.LNAMED_ELEMENT__NAME: return ProcessPackage.PIPELINE_BARRIER__NAME;
				default: return -1;
			}
		}
		if (baseClass == IPipelineUnit.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case ProcessPackage.PIPELINE_BARRIER___CREATE_CONTAINMENT_ELIST__ECLASS:
				return createContainmentEList((EClass)arguments.get(0));
			case ProcessPackage.PIPELINE_BARRIER___LCONTENTS:
				return lContents();
			case ProcessPackage.PIPELINE_BARRIER___LPARENT:
				return lParent();
			case ProcessPackage.PIPELINE_BARRIER___LALL_CONTENTS:
				return lAllContents();
			case ProcessPackage.PIPELINE_BARRIER___LINFERENCE_OBJECT:
				return lInferenceObject();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", stage: ");
		result.append(stage);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PipelineBarrierImpl
