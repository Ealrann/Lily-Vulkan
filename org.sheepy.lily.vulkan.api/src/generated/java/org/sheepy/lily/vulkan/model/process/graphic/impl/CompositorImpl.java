/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.variable.ModelVariablePkg;

import org.sheepy.lily.vulkan.model.DescriptorPkg;

import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.Compositor;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.lily.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compositor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl#getExtensionPkg <em>Extension Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl#getVertexShader <em>Vertex Shader</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl#getFragmentShader <em>Fragment Shader</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl#getColorAttachments <em>Color Attachments</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl#getInputAttachments <em>Input Attachments</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl#getConstantVariables <em>Constant Variables</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl#getDescriptorPkg <em>Descriptor Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositorImpl extends LilyEObject implements Compositor
{
	/**
	 * The cached value of the '{@link #getExtensionPkg() <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPkg()
	 * @generated
	 * @ordered
	 */
	protected CompositorExtensionPkg extensionPkg;

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
	 * The cached value of the '{@link #getVertexShader() <em>Vertex Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexShader()
	 * @generated
	 * @ordered
	 */
	protected Shader vertexShader;

	/**
	 * The cached value of the '{@link #getFragmentShader() <em>Fragment Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragmentShader()
	 * @generated
	 * @ordered
	 */
	protected Shader fragmentShader;

	/**
	 * The cached value of the '{@link #getColorAttachments() <em>Color Attachments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<Attachment> colorAttachments;

	/**
	 * The cached value of the '{@link #getInputAttachments() <em>Input Attachments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtraAttachment> inputAttachments;

	/**
	 * The cached value of the '{@link #getConstantVariables() <em>Constant Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantVariables()
	 * @generated
	 * @ordered
	 */
	protected ModelVariablePkg constantVariables;

	/**
	 * The cached value of the '{@link #getDescriptorPkg() <em>Descriptor Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorPkg()
	 * @generated
	 * @ordered
	 */
	protected DescriptorPkg descriptorPkg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositorImpl()
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
		return GraphicPackage.Literals.COMPOSITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositorExtensionPkg getExtensionPkg()
	{
		if (extensionPkg != null && ((EObject)extensionPkg).eIsProxy())
		{
			InternalEObject oldExtensionPkg = extensionPkg;
			extensionPkg = (CompositorExtensionPkg)eResolveProxy(oldExtensionPkg);
			if (extensionPkg != oldExtensionPkg)
			{
				InternalEObject newExtensionPkg = extensionPkg;
				NotificationChain msgs = oldExtensionPkg.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.COMPOSITOR__EXTENSION_PKG, null, null);
				if (newExtensionPkg.eInternalContainer() == null)
				{
					msgs = newExtensionPkg.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.COMPOSITOR__EXTENSION_PKG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.COMPOSITOR__EXTENSION_PKG, oldExtensionPkg, extensionPkg));
			}
		}
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositorExtensionPkg basicGetExtensionPkg()
	{
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionPkg(CompositorExtensionPkg newExtensionPkg, NotificationChain msgs)
	{
		CompositorExtensionPkg oldExtensionPkg = extensionPkg;
		extensionPkg = newExtensionPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__EXTENSION_PKG, oldExtensionPkg, newExtensionPkg);
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
	public void setExtensionPkg(CompositorExtensionPkg newExtensionPkg)
	{
		if (newExtensionPkg != extensionPkg)
		{
			NotificationChain msgs = null;
			if (extensionPkg != null)
				msgs = ((InternalEObject)extensionPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.COMPOSITOR__EXTENSION_PKG, null, msgs);
			if (newExtensionPkg != null)
				msgs = ((InternalEObject)newExtensionPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.COMPOSITOR__EXTENSION_PKG, null, msgs);
			msgs = basicSetExtensionPkg(newExtensionPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__EXTENSION_PKG, newExtensionPkg, newExtensionPkg));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Shader getVertexShader()
	{
		if (vertexShader != null && ((EObject)vertexShader).eIsProxy())
		{
			InternalEObject oldVertexShader = vertexShader;
			vertexShader = (Shader)eResolveProxy(oldVertexShader);
			if (vertexShader != oldVertexShader)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.COMPOSITOR__VERTEX_SHADER, oldVertexShader, vertexShader));
			}
		}
		return vertexShader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shader basicGetVertexShader()
	{
		return vertexShader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexShader(Shader newVertexShader)
	{
		Shader oldVertexShader = vertexShader;
		vertexShader = newVertexShader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__VERTEX_SHADER, oldVertexShader, vertexShader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Shader getFragmentShader()
	{
		if (fragmentShader != null && ((EObject)fragmentShader).eIsProxy())
		{
			InternalEObject oldFragmentShader = fragmentShader;
			fragmentShader = (Shader)eResolveProxy(oldFragmentShader);
			if (fragmentShader != oldFragmentShader)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.COMPOSITOR__FRAGMENT_SHADER, oldFragmentShader, fragmentShader));
			}
		}
		return fragmentShader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shader basicGetFragmentShader()
	{
		return fragmentShader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFragmentShader(Shader newFragmentShader)
	{
		Shader oldFragmentShader = fragmentShader;
		fragmentShader = newFragmentShader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__FRAGMENT_SHADER, oldFragmentShader, fragmentShader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attachment> getColorAttachments()
	{
		if (colorAttachments == null)
		{
			colorAttachments = new EObjectResolvingEList<Attachment>(Attachment.class, this, GraphicPackage.COMPOSITOR__COLOR_ATTACHMENTS);
		}
		return colorAttachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExtraAttachment> getInputAttachments()
	{
		if (inputAttachments == null)
		{
			inputAttachments = new EObjectResolvingEList<ExtraAttachment>(ExtraAttachment.class, this, GraphicPackage.COMPOSITOR__INPUT_ATTACHMENTS);
		}
		return inputAttachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelVariablePkg getConstantVariables()
	{
		return constantVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstantVariables(ModelVariablePkg newConstantVariables, NotificationChain msgs)
	{
		ModelVariablePkg oldConstantVariables = constantVariables;
		constantVariables = newConstantVariables;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES, oldConstantVariables, newConstantVariables);
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
	public void setConstantVariables(ModelVariablePkg newConstantVariables)
	{
		if (newConstantVariables != constantVariables)
		{
			NotificationChain msgs = null;
			if (constantVariables != null)
				msgs = ((InternalEObject)constantVariables).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES, null, msgs);
			if (newConstantVariables != null)
				msgs = ((InternalEObject)newConstantVariables).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES, null, msgs);
			msgs = basicSetConstantVariables(newConstantVariables, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES, newConstantVariables, newConstantVariables));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorPkg getDescriptorPkg()
	{
		return descriptorPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptorPkg(DescriptorPkg newDescriptorPkg, NotificationChain msgs)
	{
		DescriptorPkg oldDescriptorPkg = descriptorPkg;
		descriptorPkg = newDescriptorPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG, oldDescriptorPkg, newDescriptorPkg);
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
	public void setDescriptorPkg(DescriptorPkg newDescriptorPkg)
	{
		if (newDescriptorPkg != descriptorPkg)
		{
			NotificationChain msgs = null;
			if (descriptorPkg != null)
				msgs = ((InternalEObject)descriptorPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG, null, msgs);
			if (newDescriptorPkg != null)
				msgs = ((InternalEObject)newDescriptorPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG, null, msgs);
			msgs = basicSetDescriptorPkg(newDescriptorPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG, newDescriptorPkg, newDescriptorPkg));
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
			case GraphicPackage.COMPOSITOR__EXTENSION_PKG:
				return basicSetExtensionPkg(null, msgs);
			case GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES:
				return basicSetConstantVariables(null, msgs);
			case GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG:
				return basicSetDescriptorPkg(null, msgs);
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
			case GraphicPackage.COMPOSITOR__EXTENSION_PKG:
				if (resolve) return getExtensionPkg();
				return basicGetExtensionPkg();
			case GraphicPackage.COMPOSITOR__NAME:
				return getName();
			case GraphicPackage.COMPOSITOR__VERTEX_SHADER:
				if (resolve) return getVertexShader();
				return basicGetVertexShader();
			case GraphicPackage.COMPOSITOR__FRAGMENT_SHADER:
				if (resolve) return getFragmentShader();
				return basicGetFragmentShader();
			case GraphicPackage.COMPOSITOR__COLOR_ATTACHMENTS:
				return getColorAttachments();
			case GraphicPackage.COMPOSITOR__INPUT_ATTACHMENTS:
				return getInputAttachments();
			case GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES:
				return getConstantVariables();
			case GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG:
				return getDescriptorPkg();
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
			case GraphicPackage.COMPOSITOR__EXTENSION_PKG:
				setExtensionPkg((CompositorExtensionPkg)newValue);
				return;
			case GraphicPackage.COMPOSITOR__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.COMPOSITOR__VERTEX_SHADER:
				setVertexShader((Shader)newValue);
				return;
			case GraphicPackage.COMPOSITOR__FRAGMENT_SHADER:
				setFragmentShader((Shader)newValue);
				return;
			case GraphicPackage.COMPOSITOR__COLOR_ATTACHMENTS:
				getColorAttachments().clear();
				getColorAttachments().addAll((Collection<? extends Attachment>)newValue);
				return;
			case GraphicPackage.COMPOSITOR__INPUT_ATTACHMENTS:
				getInputAttachments().clear();
				getInputAttachments().addAll((Collection<? extends ExtraAttachment>)newValue);
				return;
			case GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES:
				setConstantVariables((ModelVariablePkg)newValue);
				return;
			case GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)newValue);
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
			case GraphicPackage.COMPOSITOR__EXTENSION_PKG:
				setExtensionPkg((CompositorExtensionPkg)null);
				return;
			case GraphicPackage.COMPOSITOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.COMPOSITOR__VERTEX_SHADER:
				setVertexShader((Shader)null);
				return;
			case GraphicPackage.COMPOSITOR__FRAGMENT_SHADER:
				setFragmentShader((Shader)null);
				return;
			case GraphicPackage.COMPOSITOR__COLOR_ATTACHMENTS:
				getColorAttachments().clear();
				return;
			case GraphicPackage.COMPOSITOR__INPUT_ATTACHMENTS:
				getInputAttachments().clear();
				return;
			case GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES:
				setConstantVariables((ModelVariablePkg)null);
				return;
			case GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)null);
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
			case GraphicPackage.COMPOSITOR__EXTENSION_PKG:
				return extensionPkg != null;
			case GraphicPackage.COMPOSITOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.COMPOSITOR__VERTEX_SHADER:
				return vertexShader != null;
			case GraphicPackage.COMPOSITOR__FRAGMENT_SHADER:
				return fragmentShader != null;
			case GraphicPackage.COMPOSITOR__COLOR_ATTACHMENTS:
				return colorAttachments != null && !colorAttachments.isEmpty();
			case GraphicPackage.COMPOSITOR__INPUT_ATTACHMENTS:
				return inputAttachments != null && !inputAttachments.isEmpty();
			case GraphicPackage.COMPOSITOR__CONSTANT_VARIABLES:
				return constantVariables != null;
			case GraphicPackage.COMPOSITOR__DESCRIPTOR_PKG:
				return descriptorPkg != null;
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
				case GraphicPackage.COMPOSITOR__NAME: return TypesPackage.LNAMED_ELEMENT__NAME;
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
				case TypesPackage.LNAMED_ELEMENT__NAME: return GraphicPackage.COMPOSITOR__NAME;
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
			case GraphicPackage.COMPOSITOR___LINFERENCE_OBJECT:
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CompositorImpl
