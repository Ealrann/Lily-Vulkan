/**
 */
package org.sheepy.vulkan.model.process.impl;

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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.common.api.util.LTreeIterator;
import org.sheepy.common.model.inference.IInferenceObject;
import org.sheepy.common.model.root.LObject;
import org.sheepy.common.model.root.RootPackage.Literals;
import org.sheepy.common.model.types.LNamedElement;
import org.sheepy.common.model.types.TypesPackage;
import org.sheepy.vulkan.model.IResource;

import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.IProcessUnit;
import org.sheepy.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.process.ProcessSemaphore;
import org.sheepy.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getDescriptorSets <em>Descriptor Sets</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getUnits <em>Units</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getSemaphores <em>Semaphores</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#isResetAllowed <em>Reset Allowed</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#isInitializedSignalizedSemaphore <em>Initialized Signalized Semaphore</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getDependentProcesses <em>Dependent Processes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractProcessImpl extends MinimalEObjectImpl.Container implements AbstractProcess
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
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<IResource> resources;

	/**
	 * The cached value of the '{@link #getDescriptorSets() <em>Descriptor Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSets()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptorSet> descriptorSets;

	/**
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<IProcessUnit> units;

	/**
	 * The cached value of the '{@link #getSemaphores() <em>Semaphores</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemaphores()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessSemaphore> semaphores;

	/**
	 * The default value of the '{@link #isResetAllowed() <em>Reset Allowed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetAllowed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESET_ALLOWED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResetAllowed() <em>Reset Allowed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetAllowed()
	 * @generated
	 * @ordered
	 */
	protected boolean resetAllowed = RESET_ALLOWED_EDEFAULT;

	/**
	 * The default value of the '{@link #isInitializedSignalizedSemaphore() <em>Initialized Signalized Semaphore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedSignalizedSemaphore()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZED_SIGNALIZED_SEMAPHORE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitializedSignalizedSemaphore() <em>Initialized Signalized Semaphore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedSignalizedSemaphore()
	 * @generated
	 * @ordered
	 */
	protected boolean initializedSignalizedSemaphore = INITIALIZED_SIGNALIZED_SEMAPHORE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependentProcesses() <em>Dependent Processes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependentProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessSemaphore> dependentProcesses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcessImpl()
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
		return ProcessPackage.Literals.ABSTRACT_PROCESS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CONTENT_OBJECTS, oldContentObjects, contentObjects));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IResource> getResources()
	{
		if (resources == null)
		{
			resources = new EObjectContainmentEList<IResource>(IResource.class, this, ProcessPackage.ABSTRACT_PROCESS__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DescriptorSet> getDescriptorSets()
	{
		if (descriptorSets == null)
		{
			descriptorSets = new EObjectContainmentEList<DescriptorSet>(DescriptorSet.class, this, ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS);
		}
		return descriptorSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IProcessUnit> getUnits()
	{
		if (units == null)
		{
			units = new EObjectContainmentEList<IProcessUnit>(IProcessUnit.class, this, ProcessPackage.ABSTRACT_PROCESS__UNITS);
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResetAllowed()
	{
		return resetAllowed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResetAllowed(boolean newResetAllowed)
	{
		boolean oldResetAllowed = resetAllowed;
		resetAllowed = newResetAllowed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED, oldResetAllowed, resetAllowed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInitializedSignalizedSemaphore()
	{
		return initializedSignalizedSemaphore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitializedSignalizedSemaphore(boolean newInitializedSignalizedSemaphore)
	{
		boolean oldInitializedSignalizedSemaphore = initializedSignalizedSemaphore;
		initializedSignalizedSemaphore = newInitializedSignalizedSemaphore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE, oldInitializedSignalizedSemaphore, initializedSignalizedSemaphore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessSemaphore> getDependentProcesses()
	{
		if (dependentProcesses == null)
		{
			dependentProcesses = new EObjectWithInverseResolvingEList<ProcessSemaphore>(ProcessSemaphore.class, this, ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES, ProcessPackage.PROCESS_SEMAPHORE__PROCESS);
		}
		return dependentProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessSemaphore> getSemaphores()
	{
		if (semaphores == null)
		{
			semaphores = new EObjectContainmentEList<ProcessSemaphore>(ProcessSemaphore.class, this, ProcessPackage.ABSTRACT_PROCESS__SEMAPHORES);
		}
		return semaphores;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependentProcesses()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				return ((InternalEList<?>)getDescriptorSets()).basicRemove(otherEnd, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				return ((InternalEList<?>)getUnits()).basicRemove(otherEnd, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__SEMAPHORES:
				return ((InternalEList<?>)getSemaphores()).basicRemove(otherEnd, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES:
				return ((InternalEList<?>)getDependentProcesses()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.ABSTRACT_PROCESS__CONTENT_OBJECTS:
				return getContentObjects();
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				return getName();
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
				return isEnabled();
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				return getResources();
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				return getDescriptorSets();
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				return getUnits();
			case ProcessPackage.ABSTRACT_PROCESS__SEMAPHORES:
				return getSemaphores();
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				return isResetAllowed();
			case ProcessPackage.ABSTRACT_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE:
				return isInitializedSignalizedSemaphore();
			case ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES:
				return getDependentProcesses();
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
			case ProcessPackage.ABSTRACT_PROCESS__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends IResource>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				getDescriptorSets().clear();
				getDescriptorSets().addAll((Collection<? extends DescriptorSet>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				getUnits().clear();
				getUnits().addAll((Collection<? extends IProcessUnit>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__SEMAPHORES:
				getSemaphores().clear();
				getSemaphores().addAll((Collection<? extends ProcessSemaphore>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				setResetAllowed((Boolean)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE:
				setInitializedSignalizedSemaphore((Boolean)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES:
				getDependentProcesses().clear();
				getDependentProcesses().addAll((Collection<? extends ProcessSemaphore>)newValue);
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
			case ProcessPackage.ABSTRACT_PROCESS__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)null);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				getResources().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				getDescriptorSets().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				getUnits().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__SEMAPHORES:
				getSemaphores().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				setResetAllowed(RESET_ALLOWED_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE:
				setInitializedSignalizedSemaphore(INITIALIZED_SIGNALIZED_SEMAPHORE_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES:
				getDependentProcesses().clear();
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
			case ProcessPackage.ABSTRACT_PROCESS__CONTENT_OBJECTS:
				return contentObjects != null;
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				return resources != null && !resources.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				return descriptorSets != null && !descriptorSets.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				return units != null && !units.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__SEMAPHORES:
				return semaphores != null && !semaphores.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				return resetAllowed != RESET_ALLOWED_EDEFAULT;
			case ProcessPackage.ABSTRACT_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE:
				return initializedSignalizedSemaphore != INITIALIZED_SIGNALIZED_SEMAPHORE_EDEFAULT;
			case ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES:
				return dependentProcesses != null && !dependentProcesses.isEmpty();
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
				case ProcessPackage.ABSTRACT_PROCESS__NAME: return TypesPackage.LNAMED_ELEMENT__NAME;
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
				case TypesPackage.LNAMED_ELEMENT__NAME: return ProcessPackage.ABSTRACT_PROCESS__NAME;
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
			case ProcessPackage.ABSTRACT_PROCESS___CREATE_CONTAINMENT_ELIST__ECLASS:
				return createContainmentEList((EClass)arguments.get(0));
			case ProcessPackage.ABSTRACT_PROCESS___LCONTENTS:
				return lContents();
			case ProcessPackage.ABSTRACT_PROCESS___LPARENT:
				return lParent();
			case ProcessPackage.ABSTRACT_PROCESS___LALL_CONTENTS:
				return lAllContents();
			case ProcessPackage.ABSTRACT_PROCESS___LINFERENCE_OBJECT:
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
		result.append(", resetAllowed: ");
		result.append(resetAllowed);
		result.append(", initializedSignalizedSemaphore: ");
		result.append(initializedSignalizedSemaphore);
		result.append(')');
		return result.toString();
	}

} //AbstractProcessImpl
