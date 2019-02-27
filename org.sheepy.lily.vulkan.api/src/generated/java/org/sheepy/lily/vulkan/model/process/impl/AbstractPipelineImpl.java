/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.lang.reflect.InvocationTargetException;

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

import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;

import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#getResourcePkg <em>Resource Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#getUnits <em>Units</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#getDescriptorSet <em>Descriptor Set</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#getConstants <em>Constants</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractPipelineImpl extends MinimalEObjectImpl.Container
		implements AbstractPipeline
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
	 * The cached value of the '{@link #getResourcePkg() <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcePkg()
	 * @generated
	 * @ordered
	 */
	protected ResourcePkg resourcePkg;

	/**
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<IPipelineUnit> units;

	/**
	 * The cached value of the '{@link #getDescriptorSet() <em>Descriptor Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSet()
	 * @generated
	 * @ordered
	 */
	protected DescriptorSet descriptorSet;

	/**
	 * The cached value of the '{@link #getConstants() <em>Constants</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstants()
	 * @generated
	 * @ordered
	 */
	protected AbstractConstants constants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractPipelineImpl()
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
		return ProcessPackage.Literals.ABSTRACT_PIPELINE;
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
				ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS, oldContentObjects,
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
				ProcessPackage.ABSTRACT_PIPELINE__NAME, oldName, name));
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
				ProcessPackage.ABSTRACT_PIPELINE__ENABLED, oldEnabled, enabled));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PIPELINE__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePkg getResourcePkg()
	{
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourcePkg(ResourcePkg newResourcePkg, NotificationChain msgs)
	{
		ResourcePkg oldResourcePkg = resourcePkg;
		resourcePkg = newResourcePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourcePkg(ResourcePkg newResourcePkg)
	{
		if (newResourcePkg != resourcePkg)
		{
			NotificationChain msgs = null;
			if (resourcePkg != null) msgs = ((InternalEObject) resourcePkg).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG, null,
					msgs);
			if (newResourcePkg != null) msgs = ((InternalEObject) newResourcePkg).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG, null,
					msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG, newResourcePkg, newResourcePkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IPipelineUnit> getUnits()
	{
		if (units == null)
		{
			units = new EObjectContainmentEList<IPipelineUnit>(IPipelineUnit.class, this,
					ProcessPackage.ABSTRACT_PIPELINE__UNITS);
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorSet getDescriptorSet()
	{
		if (descriptorSet != null && descriptorSet.eIsProxy())
		{
			InternalEObject oldDescriptorSet = (InternalEObject) descriptorSet;
			descriptorSet = (DescriptorSet) eResolveProxy(oldDescriptorSet);
			if (descriptorSet != oldDescriptorSet)
			{
				if (eNotificationRequired()) eNotify(new ENotificationImpl(this,
						Notification.RESOLVE, ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET,
						oldDescriptorSet, descriptorSet));
			}
		}
		return descriptorSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptorSet basicGetDescriptorSet()
	{
		return descriptorSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorSet(DescriptorSet newDescriptorSet)
	{
		DescriptorSet oldDescriptorSet = descriptorSet;
		descriptorSet = newDescriptorSet;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET, oldDescriptorSet, descriptorSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractConstants getConstants()
	{
		if (constants != null && constants.eIsProxy())
		{
			InternalEObject oldConstants = (InternalEObject) constants;
			constants = (AbstractConstants) eResolveProxy(oldConstants);
			if (constants != oldConstants)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS, oldConstants, constants));
			}
		}
		return constants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractConstants basicGetConstants()
	{
		return constants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstants(AbstractConstants newConstants)
	{
		AbstractConstants oldConstants = constants;
		constants = newConstants;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS, oldConstants, constants));
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
		case ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG:
			return basicSetResourcePkg(null, msgs);
		case ProcessPackage.ABSTRACT_PIPELINE__UNITS:
			return ((InternalEList<?>) getUnits()).basicRemove(otherEnd, msgs);
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
		case ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS:
			return getContentObjects();
		case ProcessPackage.ABSTRACT_PIPELINE__NAME:
			return getName();
		case ProcessPackage.ABSTRACT_PIPELINE__ENABLED:
			return isEnabled();
		case ProcessPackage.ABSTRACT_PIPELINE__STAGE:
			return getStage();
		case ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG:
			return getResourcePkg();
		case ProcessPackage.ABSTRACT_PIPELINE__UNITS:
			return getUnits();
		case ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET:
			if (resolve) return getDescriptorSet();
			return basicGetDescriptorSet();
		case ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS:
			if (resolve) return getConstants();
			return basicGetConstants();
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
		case ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS:
			setContentObjects((EList<LObject>) newValue);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__NAME:
			setName((String) newValue);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__STAGE:
			setStage((ECommandStage) newValue);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG:
			setResourcePkg((ResourcePkg) newValue);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__UNITS:
			getUnits().clear();
			getUnits().addAll((Collection<? extends IPipelineUnit>) newValue);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET:
			setDescriptorSet((DescriptorSet) newValue);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS:
			setConstants((AbstractConstants) newValue);
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
		case ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS:
			setContentObjects((EList<LObject>) null);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__STAGE:
			setStage(STAGE_EDEFAULT);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG:
			setResourcePkg((ResourcePkg) null);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__UNITS:
			getUnits().clear();
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET:
			setDescriptorSet((DescriptorSet) null);
			return;
		case ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS:
			setConstants((AbstractConstants) null);
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
		case ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS:
			return contentObjects != null;
		case ProcessPackage.ABSTRACT_PIPELINE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ProcessPackage.ABSTRACT_PIPELINE__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case ProcessPackage.ABSTRACT_PIPELINE__STAGE:
			return stage != STAGE_EDEFAULT;
		case ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG:
			return resourcePkg != null;
		case ProcessPackage.ABSTRACT_PIPELINE__UNITS:
			return units != null && !units.isEmpty();
		case ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET:
			return descriptorSet != null;
		case ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS:
			return constants != null;
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
			case ProcessPackage.ABSTRACT_PIPELINE__NAME:
				return TypesPackage.LNAMED_ELEMENT__NAME;
			default:
				return -1;
			}
		}
		if (baseClass == IResourceContainer.class)
		{
			switch (derivedFeatureID)
			{
			case ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG:
				return VulkanPackage.IRESOURCE_CONTAINER__RESOURCE_PKG;
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
				return ProcessPackage.ABSTRACT_PIPELINE__NAME;
			default:
				return -1;
			}
		}
		if (baseClass == IResourceContainer.class)
		{
			switch (baseFeatureID)
			{
			case VulkanPackage.IRESOURCE_CONTAINER__RESOURCE_PKG:
				return ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
		case ProcessPackage.ABSTRACT_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS:
			return createContainmentEList((EClass) arguments.get(0));
		case ProcessPackage.ABSTRACT_PIPELINE___LCONTENTS:
			return lContents();
		case ProcessPackage.ABSTRACT_PIPELINE___LPARENT:
			return lParent();
		case ProcessPackage.ABSTRACT_PIPELINE___LALL_CONTENTS:
			return lAllContents();
		case ProcessPackage.ABSTRACT_PIPELINE___LINFERENCE_OBJECT:
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
		result.append(", name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", stage: ");
		result.append(stage);
		result.append(')');
		return result.toString();
	}

} //AbstractPipelineImpl
